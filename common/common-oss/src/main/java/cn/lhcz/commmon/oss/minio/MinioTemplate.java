package cn.lhcz.commmon.oss.minio;

import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class MinioTemplate {

    @Resource
    private MinioClient minioClient;

    /**
     * 检查文件存储桶是否存在
     * @param bucketName
     * @return
     */
    @SneakyThrows
    public boolean bucketExists(String bucketName){
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    /**
     * 创建bucket
     * @param bucketName
     */
    @SneakyThrows
    public void createBucket(String bucketName) {
        if (!bucketExists(bucketName)) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 获取全部bucket
     * @return
     */
    @SneakyThrows
    public List<Bucket> getAllBuckets() {
        return minioClient.listBuckets();
    }


    /**
     * 根据bucketName删除信息
     * @param bucketName
     */
    @SneakyThrows
    public void removeBucket(String bucketName) {
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
    }

    /**
     * 根据文件前缀查询文件
     *
     * @param bucketName bucket名称
     * @param prefix     前缀
     * @param recursive  是否递归查询
     * @return MinioItem 列表
     */
    @SneakyThrows
    public List<Object> getAllObjectsByPrefix(String bucketName, String prefix, boolean recursive) {

        Iterable<Result<Item>> objectsIterator = minioClient.listObjects(bucketName, prefix, recursive);

        return null;
    }

    /**
     * 获取文件外链
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @param expires    过期时间 <=7
     * @return url
     */
    @SneakyThrows
    public String getObjectURL(String bucketName, String objectName, Integer expires) {
        final GetPresignedObjectUrlArgs build = GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .object(objectName)
                .bucket(bucketName)
                .expiry(expires, TimeUnit.DAYS)
                .build();
        return minioClient.getPresignedObjectUrl(build);
    }

    /**
     * 获取文件外链
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @return url
     */
    @SneakyThrows
    public String getObjectURL(String bucketName, String objectName) {
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .object(objectName)
                        .bucket(bucketName)
                        .build());
    }

    /**
     * 获取文件
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @return 二进制流
     */
    @SneakyThrows
    public InputStream getObject(String bucketName, String objectName) {
        return minioClient.getObject(
                GetObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .build()
        );
    }

    /**
     * 上传文件
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @param stream     文件流
     */
    @SneakyThrows
    public void putObject(String bucketName, String objectName, InputStream stream) {
        final PutObjectArgs build = PutObjectArgs.builder().contentType("application/octet-stream")
                .stream(stream, (long) stream.available(), -1)
                .bucket(bucketName)
                .object(objectName)
                .build();
        ObjectWriteResponse response = minioClient.putObject(build);

    }

    /**
     *  上传文件
     *  https://docs.min.io/docs/java-client-api-reference#putObject
     * @param bucketName  bucket名称
     * @param objectName  文件名称
     * @param stream      文件流
     * @param size        大小
     * @param contentType 类型  video/mp4;image/png
     */
    public void putObject(String bucketName, String objectName, InputStream stream, long size, String contentType) throws Exception {
        final PutObjectArgs build = PutObjectArgs.builder()
                .contentType(contentType)
                .stream(stream, size, -1)
                .bucket(bucketName)
                .object(objectName)
                .build();
        minioClient.putObject(build);
    }

    /**
     * 获取文件信息
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     */
    @SneakyThrows
    public ObjectStat getObjectInfo(String bucketName, String objectName) {
        return minioClient.statObject(
                StatObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }

    /**
     * 删除文件
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     */
    @SneakyThrows
    public void removeObject(String bucketName, String objectName) {
        minioClient.removeObject(
                RemoveObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build());
    }

    /**
     * 获取桶策略
     * @param bucketName
     * @return
     */
    @SneakyThrows
    public String getBucketPolicy(String bucketName) {
        return minioClient.getBucketPolicy(GetBucketPolicyArgs.builder().bucket(bucketName).build());
    }

    /**
     * 修改桶策略
     * @param bucketName
     * @param policyJson
     */
    @SneakyThrows
    public void setBucketPolicy(String bucketName, String policyJson) {
        minioClient.setBucketPolicy(
                SetBucketPolicyArgs.builder()
                        .bucket(bucketName)
                        .config(policyJson)
                        .build()
        );
    }

}

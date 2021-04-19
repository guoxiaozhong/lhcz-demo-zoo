VERSION=`date "+%F-%H-%M"` ;
docker build -t 192.168.100.7/bzyq/bzyq-end-check:$VERSION . ;
docker push 192.168.100.7/bzyq/bzyq-end-check:$VERSION ;
sed -i '15c \          \image: 192.168.100.7/bzyq/bzyq-end-check:'$VERSION bzyq-end-check.yaml  ;
kubectl apply -f /root/Deploy/bzyq-end-check/bzyq-end-check.yaml --record ;



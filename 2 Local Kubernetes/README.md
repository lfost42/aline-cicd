# Kubernetes experiments

kubectl create deployment aline-mysql --image=lyndasm/aline-mysql
kubectl create deployment aline-landing --image=lyndasm/aline-landing
kubectl create deployment aline-gateway --image=lyndasm/aline-gateway

kubectl expose deployment aline-mysql --port 3306
kubectl expose deployment aline-landing --port 80 --type=NodePort
kubectl expose deployment aline-gateway --port 8080

kubectl get service aline-landing
* verify port connects to localhost using assigned port
```
NAME            TYPE       CLUSTER-IP      EXTERNAL-IP   PORT(S)        AGE
aline-landing   NodePort   10.101.59.150   <none>        80:31024/TCP   9h
```
= http://localhost:31024

kubectl get deploy/aline-gateway -o yaml > aline-gateway.yml
kubectl get deploy/aline-mysql -o yaml > aline-mysql.yml
kubectl get deploy/aline-landing -o yaml > aline-landing.yml


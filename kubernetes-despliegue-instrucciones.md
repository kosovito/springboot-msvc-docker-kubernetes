##minikube start --driver=hyperv
##minikube start --driver=docker
##minikube stop
##minikube delete
##minikube status
##crear archivo yaml de deployment
##kubectl create deployment mysql8 --image=mysql:8 --port=3306 --dry-run=client -o yaml > deployment-mysql.yaml
##aplicar plantilla yaml para desplegar deployment
##kubectl apply -f .\deployment-mysql.yaml
##exponer deployment y darle un entorno de acceso
##kubectl expose deployment mysql8 --port=3306 --type=ClusterIP
##kubectl get all -> para ver todo el escenario
##kubectl create deployment msvc-usuarios --image=kosovito/usuarios:latest --port=8001
##kubectl expose deployment msvc-usuarios --port=8001 --type=LoadBalancer
##para obtener la url del cluster para acceder al loadbalancer cuando estamos en local
##minikube service msvc-usuarios --url
##actualizar imagen de un deployment, esta debe ser distinta a la anterior, ejemplo kosovito/usuarios:v2
##kubectl set image deployment msvc-usuarios usuarios=kosovito/usuarios:v2
##aumentar réplicas de los pods
##kubectl scale deployment msvc-usuarios --replicas=3
##kubectl get service mysql8 -o yaml > svc-mysql.yaml
##kubectl create deployment msvc-usuarios --port=8001 --image=kosovito/usuarios:latest --dry-run=client -o yaml > deployment-usuarios.yaml
##kubectl get service msvc-usuarios -o yaml > svc-usuarios.yaml
##borrar un deployment desde su archivo declarativo yaml
##kubectl delete -f .\deployment-usuarios.yaml
##levantar o crear un deployment desde su archivo declarativo yaml
##kubectl apply -f .\deployment-usuarios.yaml
##lanzar dashboard web de minikub
##minikube dashboard
##creamos permiso para acceder a spring cloud kubernetes a la api de kubernetes
##kubectl create clusterrolebinding admin --clusterrole=cluster-admin --serviceaccount=default:default
##kubectl apply -f .\deployment-svc-gateway.yaml
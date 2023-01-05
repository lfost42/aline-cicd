# Aline Financial CI/CD

## Usage

Continuous integration and continuous delivery (CI/CD) is a software engineering practice that aims to improve the speed, quality, and reliability of software development by automating the build, test, and deployment process. This project established a CI/CD pipeline for our development environment.

### Aline Financial App Architecture:

![logo](diagram.png)

# Local Containerization/Automation
Localized containerization is a way of packaging our web application, along with its dependencies and runtime environment, into a container that can be easily deployed and run in the cloud. This allows us to make it easier to deploy and run the application consistently, regardless of the host environment. 

## Installation

# Requirements:

[Docker Desktop](https://www.docker.com/products/docker-desktop/)

[VS Code](https://code.visualstudio.com)

[Docker extension](https://code.visualstudio.com/docs/containers/overview)

[Heml](https://helm.sh/docs/intro/install/)

### Clone repo files:
1. Create a .env file and add values to each global variable listed in the env file.
2. Create an `Aline Financial` parent folder. 
3. Clone all [Aline Financial](https://git1.smoothstack.com/instructors/leandro-yabut/aline-financial) repos into parent folder.
4. Clone the develop branch in [Aline DevOps](https://git1.smoothstack.com/cohorts/2022/organizations/cyber-cumulus/lynda-foster/aline-devops/-/tree/develop)

### Build Docker Images and run Docker Compose

1. Follow the steps in `Clone repo files above` if you do not have `Aline Financial` repo files. 
2. From the `docker` folder, move the following files to the parent `Aline Financial folder` you created in step 2. 
`Dockerfile.maven`
`Dockerfile.node`
`docker-compose.yml`
`setup.py`
`.env` (the one you created in `Clone reop files:` step 1)
3. run `setup.py`:
- `py setup.py` or `python3 setup.py`
4. run `docker-compose.yml`
- a. right-click `docker-compose.yml`
- b. select `Compose Up` to run all services or select `Compose Up - Select Services` to build/run a subset of microservices.

### Kubernetes Local
1. Apply nginx Ingress Controller
`kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.5.1/deploy/static/provider/cloud/deploy.yaml`
2. Create namespace
`kubectl create namespace aline`

3. Apply secrets for MYSQL_PASSWORD and secret keys within the aline namespace.
`kubectl create secret generic mysql-password --from-literal DB_PASSWORD=really_good_password --namespace=aline`
`kubectl create secret generic encrypt-key --from-literal ENCRYPT_SECRET_KEY=001104a5cbe95ed3bff1495a1ae92a28 --namespace=aline`
`kubectl create secret generic jwt-key --from-literal JWT_SECRET_KEY=my-32-character-ultra-secure-and-ultra-long-secret --namespace=aline`

4. Install [bitnami](https://github.com/bitnami/charts/tree/main/bitnami/mysql)
`helm repo add my-repo https://charts.bitnami.com/bitnami`

5. Apply mysql-bn
`helm install mysql my-repo/mysql --values mainfest/mysql-bn.yaml`

6. Apply manifest files. In `k8s` folder:
`kubectl apply -f .`

7. Update /etc/localhosts to add:
`127.0.0.1 alinefinancial.com`
`127.0.0.1 landing.alinefinancial.com`
`127.0.0.1 member.alinefinancial.com`
`127.0.0.1 admin.alinefinancial.com`
`127.0.0.1 api.alinefinancial.com`

8. Explore app through alinefinancial.com. 

## Support

lynda.foster@smoothstack.com<br>
[Cyber Cumulus Jira](https://cyber-cumulus-smoothstack.atlassian.net/jira/software/projects/CC/boards/1)

## Roadmap

[Aline DevOps repo](https://git1.smoothstack.com/cohorts/2022/organizations/cyber-cumulus/lynda-foster/aline-devops) - Check the devlop branch for completed features.

- [x] Local Containerization and Automation
    - [x] Dockerize Images
    - [x] Docker Compose Local
    - [x] Kubernetes Pod Local
    - [ ] Jenkins Pipelines
    - [ ] Jenkins Integration with Sonarqube

- [ ] Cloud Containerization
    - [ ] Docker Compose Cloud
    - [ ] Kubernetes Cloud EKS

- [ ] Terraform CI/CD
    - [ ] Create Base Infrastructure
- [ ] Jenkins CI/CD
    - [ ] Docker Compose Jenkins
    - [ ] Kubernetes via Jenkins
    - [ ] Terraform Plan and Apply via Jenkins
- [ ] General CI/CD
    - [ ] Ansible Playbooks
    - [ ] Vanilla CloudFormation

## Acknowledgements
Lead Developer:

[Lynda Foster](https://git1.smoothstack.com/lynda.foster)

With support from the Cyber Cumulus Team:

[Anthony Foster](https://git1.smoothstack.com/anthony.foster)<br>
[Nathan Galler](https://git1.smoothstack.com/nathan.galler)<br>
[Dennis Ghitas](https://git1.smoothstack.com/dennis.ghitas)<br>
[Sebastian Marzal](https://git1.smoothstack.com/sebastian.marzal)

## License
[MIT License](LICENSE.md)

## Project status
Local Containerization and Automation

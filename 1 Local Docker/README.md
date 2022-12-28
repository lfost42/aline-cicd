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

### Clone repo files:
1. Create a .env file and add values to each global variable listed in the env file.
2. Create an `Aline Financial` parent folder. 
3. Clone all [Aline Financial](https://git1.smoothstack.com/instructors/leandro-yabut/aline-financial) repos into parent folder.
4. Clone the develop branch in [Aline DevOps](https://git1.smoothstack.com/cohorts/2022/organizations/cyber-cumulus/lynda-foster/aline-devops/-/tree/develop)

### Build Docker Images and run Docker Compose

1. Follow the steops in `Clone repo files above` if you do not have `Aline Financial` repo files. 
2. From the `docker` folder, move the following files to the parent `Aline Financial folder` you created in step 2. 
`Dockerfile.maven`
`Dockerfile.node`
`docker-compose.yml`
`setup.py`
`.env` (the one you created in step 1)
3. run `setup.py`:
- `py setup.py` or `python3 setup.py`
4. run `docker-compose.yml`
- a. right-click `docker-compose.yml`
- b. select `Compose Up` to run all services or select `Compose Up - Select Services` to build/run a subset of microservices.

### Kubernetes Local
1. Pull docker hub images for lyndasm/aline:
`docker pull lyndasm/aline --all-tags`

## Support

lynda.foster@smoothstack.com<br>
[Cyber Cumulus Jira](https://cyber-cumulus-smoothstack.atlassian.net/jira/software/projects/CC/boards/1)

## Roadmap

[Aline DevOps repo](https://git1.smoothstack.com/cohorts/2022/organizations/cyber-cumulus/lynda-foster/aline-devops) - Check the devlop branch for completed features.

- [ ] Local Containerization and Automation
    - [ ] Dockerize Images
    - [ ] Docker Compose Local
    - [ ] Kubernetes Pod Local
    - [ ] Jenkins Pipelines
    - [ ] Jenkins Integration with Sonarqube

- [ ] Docker CI/CD
    - [ ] Docker Compose Cloud
- [ ] Kubernetes CI/CD
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
See main README in parent folder.
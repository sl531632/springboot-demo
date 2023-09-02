// 定义镜像信息
def imageName = 'springboot-demo'
def imageTag = "v1.0"
def harbor_domain = '192.168.0.100:10010'
def harbor_user = 'admin'
def harbor_pwd = 'pwdxd12345'


pipeline {
  agent any

  stages {

    stage('Build') {
      steps {
		// 使用Maven进行构建，跳过测试
		sh "mvn clean package -DskipTests"

      }
    }

    stage('Build Image') {
      steps{
        script {
          // 构建Docker镜像
          sh "docker build -t ${imageName}:${imageTag} ."
        }
      }
    }

    stage('Push Image') {
      steps{
        script {
		  
            // 登录Harbor
            sh "docker login -u ${harbor_user} -p ${harbor_pwd} ${harbor_domain}"
            // 推送镜像
            sh "docker push ${harbor_domain}/cicd/${imageName}:${imageTag}" 
        }  
      }
    }

  }
}
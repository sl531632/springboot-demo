// 定义镜像信息
def imageName = 'springboot-demo'
def imageTag = "${env.BUILD_NUMBER}"
def harbor_domain = '192.168.0.100:10010'
def harbor_user = 'admin'
def harbor_pwd = 'pwdxd12345'


pipeline {
  agent any

  stages {

    stage('Build') {
      steps {
        // 构建和测试应用
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
            sh "docker push ${imageName}:${imageTag}" 
        }  
      }
    }

  }
}
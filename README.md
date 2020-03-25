##个人博客
##学习资料
[spring文档](https://spring.io/guides/gs/serving-web-content/)
[ui框架地址](https://v3.bootcss.com/getting-started/)
[网络请求框架](https://square.github.io/okhttp/)
[github之API登录文档](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/)
##工具
idea
git
status
 


##新建github仓库与本地同步(通过git托管)
##git提交命令
1.git init
2.git add .
3.git status
4.git commit -m "备注"
5.git remote add origin (你的github网址)
6.git push -u origin master

##如果后期存在修改
1.git add .
2.git status
命令修改上一次变更内容
3.git commit --amend --no-edit
3.git push

##github访问请求
看github的api接口
(https://github.com/settings/applications/new)
1.新建github OAuth application
填写 名字
    主页地址（一般默认创建springboot的组织）
2.创建成功后，上传图标
具体流程看visio (C:\Users\a\Desktop\githupp登录博客时序图)
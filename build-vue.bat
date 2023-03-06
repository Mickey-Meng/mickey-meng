
cd mickey-ui/mickey-ui-admin-vue3 && call echo Build_[01]注册淘宝镜像 && npm config set registry https://registry.npm.taobao.org && call echo Build_[02]检查注册结果 && npm config get registry && call echo Build_[03]安装依赖 && npm install && call echo Build_[03]编译打包出dist-pro文件夹 && npm run build:pro


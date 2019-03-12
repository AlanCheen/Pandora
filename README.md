# Pandora


Pandora 是一个 Android 工具类的集合，包含两个版本：

1. basic 版本，只会包含非常非常基础的 Utils ,比如全局提供 Application 能力的类；
2. full 版本，会包含各种 Utils ，涉及到 Android 开发的方方面面；

当只需要非常基础的能力时可以依赖 basic 版本： `1.0.1-basic` (带有 -basic 后缀), 代码在 `basic` 分支；

当需要依赖大量 Pandora 包含的 Utils 时，才需要依赖 full 版本：`0.0.5` ，代码在 `master` 分支；



**推荐只依赖 basic 版本，避免引入过多不需要的类，增加包体积。**

## Getting Started

```groovy
implementation 'me.yifeiyuan.pandora:pandora:version'
```

# ExEmailDemo - 全局捕获异常并发送到邮箱

## 项目目录

- ex-email: lib 库(注解和服务)
- simple: 使用示例

## 使用方式

Yaml 配置文件:

```yaml
my:
  project-name: 项目名
  email:
    host: smtp.163.com      // 163 邮箱
    username: from@163.com  // 邮箱账号
    password: xxx           // 邮箱 smtp 授权码
    global-to: to@163.com   // 全局接收邮箱
```

代码:

1. 配置
```java
/**
 * @author: yangpengwei
 * @time: 2021/5/19 5:41 下午
 * @description 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private EmailSyncService emailSyncService;

    @ExceptionHandler(Exception.class)
    public Exception onEx(Exception e) {
        emailSyncService.sendByEx(e);
        return e;
    }
}
```

2. 使用
```java
// 类注解
@EmailNumber("ypwcode@126.com")
public class xxx {
    // 方法注解
    @EmailNumber("ypwcode@yeah.net")
    public void xxx()  {
        // TODO xxx
    }
}
```

## 说明

- 如果代码出现异常, 优先查找异常方法上的邮箱注解, 其次查找异常类上的邮箱注解, 再其次是全局默认邮箱
- 首个异常类注解为主接收邮箱, 其他相关异常类为抄送邮箱


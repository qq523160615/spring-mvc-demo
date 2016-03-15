<html>
<head>
    <title>
        请输入注册信息
    </title>
</head>
<body>
    <div style="margin: 0 auto;padding-top: 100px;" align="center">
        <form action="/doRegister" method="post">
            <p>
                ${ERR_username}
                <span>用户名:</span><input type="text" name="username">
            </p>
            <p>
                ${ERR_password}
                <span>密码:</span><input type="password" name="password">
            </p>
            <p>
                ${ERR_age}
                <span>年龄:</span><input type="text" name="age">
            </p>
            <p>
                ${ERR_realName}
                <span>真实姓名:</span><input type="text" name="realName">
            </p>
            <p>
                ${ERR_email}
                <span>邮箱:</span><input type="text" name="email">
            </p>
            <p>
                <input type="submit" name="登录">
            </p>
        </form>

    </div>
</body>
</html>
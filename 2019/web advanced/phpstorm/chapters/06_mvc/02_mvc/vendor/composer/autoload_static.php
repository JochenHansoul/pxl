<?php

// autoload_static.php @generated by Composer

namespace Composer\Autoload;

class ComposerStaticInit80aafb86c30d10174a7dda6c5d7f8222
{
    public static $files = array (
        'cf97c57bfe0f23854afd2f3818abb7a0' => __DIR__ . '/..' . '/zendframework/zend-diactoros/src/functions/create_uploaded_file.php',
        '9bf37a3d0dad93e29cb4e1b1bfab04e9' => __DIR__ . '/..' . '/zendframework/zend-diactoros/src/functions/marshal_headers_from_sapi.php',
        'ce70dccb4bcc2efc6e94d2ee526e6972' => __DIR__ . '/..' . '/zendframework/zend-diactoros/src/functions/marshal_method_from_sapi.php',
        'f86420df471f14d568bfcb71e271b523' => __DIR__ . '/..' . '/zendframework/zend-diactoros/src/functions/marshal_protocol_version_from_sapi.php',
        'b87481e008a3700344428ae089e7f9e5' => __DIR__ . '/..' . '/zendframework/zend-diactoros/src/functions/marshal_uri_from_sapi.php',
        '0b0974a5566a1077e4f2e111341112c1' => __DIR__ . '/..' . '/zendframework/zend-diactoros/src/functions/normalize_server.php',
        '1ca3bc274755662169f9629d5412a1da' => __DIR__ . '/..' . '/zendframework/zend-diactoros/src/functions/normalize_uploaded_files.php',
        '40360c0b9b437e69bcbb7f1349ce029e' => __DIR__ . '/..' . '/zendframework/zend-diactoros/src/functions/parse_cookie_header.php',
        '253c157292f75eb38082b5acb06f3f01' => __DIR__ . '/..' . '/nikic/fast-route/src/functions.php',
        '538ca81a9a966a6716601ecf48f4eaef' => __DIR__ . '/..' . '/opis/closure/functions.php',
        'b33e3d135e5d9e47d845c576147bda89' => __DIR__ . '/..' . '/php-di/php-di/src/functions.php',
    );

    public static $prefixLengthsPsr4 = array (
        'Z' => 
        array (
            'Zend\\Diactoros\\' => 15,
        ),
        'R' => 
        array (
            'Relay\\' => 6,
        ),
        'P' => 
        array (
            'Psr\\Http\\Server\\' => 16,
            'Psr\\Http\\Message\\' => 17,
            'Psr\\Container\\' => 14,
            'PhpDocReader\\' => 13,
        ),
        'O' => 
        array (
            'Opis\\Closure\\' => 13,
        ),
        'M' => 
        array (
            'Middlewares\\Utils\\' => 18,
            'Middlewares\\' => 12,
        ),
        'I' => 
        array (
            'Invoker\\' => 8,
        ),
        'F' => 
        array (
            'FastRoute\\' => 10,
        ),
        'E' => 
        array (
            'ExampleApp\\' => 11,
        ),
        'D' => 
        array (
            'DI\\' => 3,
        ),
    );

    public static $prefixDirsPsr4 = array (
        'Zend\\Diactoros\\' => 
        array (
            0 => __DIR__ . '/..' . '/zendframework/zend-diactoros/src',
        ),
        'Relay\\' => 
        array (
            0 => __DIR__ . '/..' . '/relay/relay/src',
        ),
        'Psr\\Http\\Server\\' => 
        array (
            0 => __DIR__ . '/..' . '/psr/http-server-handler/src',
            1 => __DIR__ . '/..' . '/psr/http-server-middleware/src',
        ),
        'Psr\\Http\\Message\\' => 
        array (
            0 => __DIR__ . '/..' . '/psr/http-factory/src',
            1 => __DIR__ . '/..' . '/psr/http-message/src',
        ),
        'Psr\\Container\\' => 
        array (
            0 => __DIR__ . '/..' . '/psr/container/src',
        ),
        'PhpDocReader\\' => 
        array (
            0 => __DIR__ . '/..' . '/php-di/phpdoc-reader/src/PhpDocReader',
        ),
        'Opis\\Closure\\' => 
        array (
            0 => __DIR__ . '/..' . '/opis/closure/src',
        ),
        'Middlewares\\Utils\\' => 
        array (
            0 => __DIR__ . '/..' . '/middlewares/utils/src',
        ),
        'Middlewares\\' => 
        array (
            0 => __DIR__ . '/..' . '/middlewares/fast-route/src',
            1 => __DIR__ . '/..' . '/middlewares/request-handler/src',
        ),
        'Invoker\\' => 
        array (
            0 => __DIR__ . '/..' . '/php-di/invoker/src',
        ),
        'FastRoute\\' => 
        array (
            0 => __DIR__ . '/..' . '/nikic/fast-route/src',
        ),
        'ExampleApp\\' => 
        array (
            0 => __DIR__ . '/../..' . '/src',
        ),
        'DI\\' => 
        array (
            0 => __DIR__ . '/..' . '/php-di/php-di/src',
        ),
    );

    public static function getInitializer(ClassLoader $loader)
    {
        return \Closure::bind(function () use ($loader) {
            $loader->prefixLengthsPsr4 = ComposerStaticInit80aafb86c30d10174a7dda6c5d7f8222::$prefixLengthsPsr4;
            $loader->prefixDirsPsr4 = ComposerStaticInit80aafb86c30d10174a7dda6c5d7f8222::$prefixDirsPsr4;

        }, null, ClassLoader::class);
    }
}

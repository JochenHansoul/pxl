<?php

// autoload_psr4.php @generated by Composer

$vendorDir = dirname(dirname(__FILE__));
$baseDir = dirname($vendorDir);

return array(
    'Zend\\Diactoros\\' => array($vendorDir . '/zendframework/zend-diactoros/src'),
    'Relay\\' => array($vendorDir . '/relay/relay/src'),
    'Psr\\Http\\Server\\' => array($vendorDir . '/psr/http-server-handler/src', $vendorDir . '/psr/http-server-middleware/src'),
    'Psr\\Http\\Message\\' => array($vendorDir . '/psr/http-factory/src', $vendorDir . '/psr/http-message/src'),
    'Psr\\Container\\' => array($vendorDir . '/psr/container/src'),
    'PhpDocReader\\' => array($vendorDir . '/php-di/phpdoc-reader/src/PhpDocReader'),
    'Opis\\Closure\\' => array($vendorDir . '/opis/closure/src'),
    'Middlewares\\Utils\\' => array($vendorDir . '/middlewares/utils/src'),
    'Middlewares\\' => array($vendorDir . '/middlewares/fast-route/src', $vendorDir . '/middlewares/request-handler/src'),
    'Invoker\\' => array($vendorDir . '/php-di/invoker/src'),
    'FastRoute\\' => array($vendorDir . '/nikic/fast-route/src'),
    'ExampleApp\\' => array($baseDir . '/src'),
    'DI\\' => array($vendorDir . '/php-di/php-di/src'),
);

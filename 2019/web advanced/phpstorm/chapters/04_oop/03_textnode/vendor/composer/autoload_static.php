<?php

// autoload_static.php @generated by Composer

namespace Composer\Autoload;

class ComposerStaticInit874594de8f871cef6bd0a6dd72901714
{
    public static $prefixLengthsPsr4 = array (
        'T' => 
        array (
            'TextNode\\' => 9,
        ),
    );

    public static $prefixDirsPsr4 = array (
        'TextNode\\' => 
        array (
            0 => __DIR__ . '/../..' . '/src/textnode',
        ),
    );

    public static $classMap = array (
        'TextNode\\TextNode' => __DIR__ . '/../..' . '/src/textnode/TextNode.php',
    );

    public static function getInitializer(ClassLoader $loader)
    {
        return \Closure::bind(function () use ($loader) {
            $loader->prefixLengthsPsr4 = ComposerStaticInit874594de8f871cef6bd0a6dd72901714::$prefixLengthsPsr4;
            $loader->prefixDirsPsr4 = ComposerStaticInit874594de8f871cef6bd0a6dd72901714::$prefixDirsPsr4;
            $loader->classMap = ComposerStaticInit874594de8f871cef6bd0a6dd72901714::$classMap;

        }, null, ClassLoader::class);
    }
}

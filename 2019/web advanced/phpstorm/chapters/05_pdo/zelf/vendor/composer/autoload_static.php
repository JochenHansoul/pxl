<?php

// autoload_static.php @generated by Composer

namespace Composer\Autoload;

class ComposerStaticInitbfa373e6aaa8233d80dd96f6a056546e
{
    public static $files = array (
        'a46473506fc7714513784a77d0b0da23' => __DIR__ . '/../..' . '/src/Database/DSN.php',
        '8d97e0ff1b27e3d1d046344da262f5cb' => __DIR__ . '/../..' . '/src/Database/OPTIONS.php',
        '0a6096c1a077a2aa865ad21656e42008' => __DIR__ . '/../..' . '/src/User/USERS.php',
    );

    public static $prefixLengthsPsr4 = array (
        'D' => 
        array (
            'Database\\' => 9,
        ),
    );

    public static $prefixDirsPsr4 = array (
        'Database\\' => 
        array (
            0 => __DIR__ . '/../..' . '/src/Database',
        ),
    );

    public static $classMap = array (
        'Database\\PDODatabases' => __DIR__ . '/../..' . '/src/Database/PDODatabases.php',
    );

    public static function getInitializer(ClassLoader $loader)
    {
        return \Closure::bind(function () use ($loader) {
            $loader->prefixLengthsPsr4 = ComposerStaticInitbfa373e6aaa8233d80dd96f6a056546e::$prefixLengthsPsr4;
            $loader->prefixDirsPsr4 = ComposerStaticInitbfa373e6aaa8233d80dd96f6a056546e::$prefixDirsPsr4;
            $loader->classMap = ComposerStaticInitbfa373e6aaa8233d80dd96f6a056546e::$classMap;

        }, null, ClassLoader::class);
    }
}

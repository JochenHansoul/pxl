<?php

declare(strict_types=1);

//echo $_SERVER['DOCUMENT_ROOT'] . "\n";
//echo __DIR__ . "\n";
//echo dirname(__DIR__) . "\n";

use DI\ContainerBuilder;
use ExampleApp\HelloWorld;
use FastRoute\RouteCollector;
use Middlewares\FastRoute;
use Middlewares\RequestHandler;
use Relay\Relay;
use Zend\Diactoros\ServerRequestFactory;

use function DI\create;
use function FastRoute\simpleDispatcher;

require_once dirname(__DIR__) . '/vendor/autoload.php';

$containerBuilder = new ContainerBuilder();
$containerBuilder->useAutowiring(false);
$containerBuilder->useAnnotations(false);
$containerBuilder->addDefinitions([
    HelloWorld::class => create(HelloWorld::class)
]);

$container = $containerBuilder->build();

$middlewareQueue = [];

$routes = simpleDispatcher(function (RouteCollector $r) {
    $r->get('/hello', HelloWorld::class);
});
$middlewareQueue[] = new FastRoute($routes); // determines if a request is valid and can actually be handled by the application
$middlewareQueue[] = new RequestHandler(); // sends Request to the handler configured for that route in the routes definition

$requestHandler = new Relay($middlewareQueue);
$requestHandler->handle(ServerRequestFactory::fromGlobals());
// ServerRequestFactory::fromGlobals() pull together all the information necessary to create a new Request and hand it off to Relay.
// This is where Request enters our middleware stack.

@EnableFeignClient
@FeignClient

Create an interface and annotate it with @FeignClient passing the service application name. Then define methods in it the same way we define methods in a Spring MVC controller. All the annotations that we use while declaring a controller method can also be used inside feign client interface method declaration.

Need to run the following applications before running this
* 06a_eureka_server
* 08a_service_instance_one
* 08b_service_instance_two
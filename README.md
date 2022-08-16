# springboot-crud

root: bloom@09

# Database Scripts :
create database spring;
use spring;
select * from product;

# REST API Endpoints with payloads:
Resource | URL                                       | Operation                                                  | Paylaod                                                                            |
-------- |-------------------------------------------|------------------------------------------------------------|------------------------------------------------------------------------------------|
Add Product | http://localhost:9080/addProduct          | POST                                                       | {"name": "Fan","quantity": 11,"price": 800}                                                     
Add Products | http://localhost:9080/addProducts         | POST                                                       |  [{"name": "Tent","quantity": 5,"price": 250},{"name": "Photo Frame","quantity": 7,"price": 14}] 
Get Products | http://localhost:9080/products            | GET                                                        |
Get Products By Id | http://localhost:9080/productById/1       | GET                                                        |
Get Products By Name | http://localhost:9080/product/Pen         | GET |
Delete Products By Id| http://localhost:9080/delete/11           | DELETE | {"name": "Fan","quantity": 11,"price": 800}                
Update Product | http://localhost:9080/update              | PUT | {"id": 4,"name": "Projector","quantity": 3,"price": 999.0} 

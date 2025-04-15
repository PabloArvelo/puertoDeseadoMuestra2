# Pedido de un cliente de una aplicación para gestionar su empresa de seguridad

El proyecto aun está en construcción

Actualmente implementa:
- CRUD DE ASOCIADOS
    - en este item, permite:
	- alta de asociados con datos personales y foto
	- búsqueda de asociados por numero de CUIL
	- búsqueda de asociados por apellido

- CONTROL DE SOCK DE UNIFORMES
    - en este item, permite:
        - alta de prenda con talle
        - ingreso de stock de prendas por compra
        - ingreso de stock de prendas usadas
        - control del stock general de prendas por talle y estado (nuevos y usados)
        - impresión en PDF del stock general de uniformes
        - entrega de uniformes a aociados
        - impresión de comprobante de entrega de uniformes en PDF
        - visualizar el uniforme entregado al asociado
        - entregar nuevas prendas del uniforme al asociado
        - devolución del uniforme que tenía el asociado

- CONTROL DE FECHA DE HABILITACIÓN DE ASOCIADO
    - en la vista de asociado, de manera visual muestra el estado de la habilitación junto con la fecha que expira
    - avisos automáticos vía mail con 45, 20, 7 días de anticipación al vencimiento y el día que expiró informando que está vencida.

- LIQUIDACION DE ANTICIPOS DE RETORNO (pago de sueldos)
    - en este item, permite:
        - exporta un excel con todo el padrón de asociados de la cooperativa a liquidar
	- tras completar el excel con la liquidación y guardarlo en CSV, permite importar liquidación
	- aprobar la liquidación creada
	- generar los PDFs de los recibos (una vez aprobada la liquidación, si no está aprobada, no lo permite)
	- impresión de los recibos  

- SEGURIDAD 
    - en este item, permite:
        - creación de usuarios con sus distintos roles
	- recupero de nombre de usuario via email



- Tecnologías usadas:
	- SPRING BOOT 
	- MAVEN 
	- JAVA 
	- MYSQL
	- HTML 
	- JAVASCRIPT 
	- CSS
	- THYMELEAF 
	- SPRING SECURITY
 
- IDE IntelliJ Idea

![preview](https://drive.google.com/uc?export=view&id=1kPfMj5S33HfNt8CHhFWEfU30OgKuZfvJ)
![preview](https://drive.google.com/uc?export=view&id=169RxFcfv-QxHDAE7YrPxiebJaMCWkvXG)
![preview](https://drive.google.com/uc?export=view&id=1GmNX1S4C7_8NUKpwFKd7P66JmtFnniQf)

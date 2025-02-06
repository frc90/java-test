## Descripción
Una empresa quiere tener registros para sus empleados, los cuales tienen múltiples atributos, y particularmente desean poder saber cuáles son los próximos aniversarios y cumpleaños. Por ejemplo, si hoy es viernes 11 de noviembre y necesito saber cuáles son los eventos en los próximos 10 días, el sistema deberá poder mostrar aquellos empleados activos que ingresaron a la empresa entre el 11 y 21 de noviembre de años anteriores, así como también aquellos empleados que nacieron en ese mismo período.
## Requerimientos
### Endpoints para manejar empleados:
- Crear, editar, eliminar lógicamente, encontrar y listar empleados.
### Funcionalidades principales:
- Calcular los eventos, cumpleaños y aniversarios, a partir de una fecha de partida y una cantidad **X** de días hacia adelante. Ejemplo: cumple **Y** años o este es su **Z** aniversario.
- Un endpoint para obtener esta información. **X** debe ser un parámetro.
### Automatización:
- Un mecanismo automático (CRON) que se ejecute todas las mañanas. **X** debe ser una constante o variable de entorno.
- Enviar un email con esta información.
  - El formato del email no tiene relevancia.
  - Las casillas de destino pueden estar hardcoded.
  - Las credenciales para el servidor que envía los mails pueden estar hardcoded.
### API externa:
- Consultar una API externa para saber si hoy, mañana o pasado son días feriados.
  - Se recomienda utilizar la siguiente API (https://app.abstractapi.com/api/holidays/documentation)
    - **API key**: `ebdfb3febb9944cd898f8c7767c6655d`
  - Ejemplo de uso en el anexo.
  - Se puede utilizar cualquier otra API.
## Se valorará
- Uso de Java 17 o 21
- Uso de SpringBoot y sus herramientas
- Herramientas para documentación de API'S
- Código extensible, por ejemplo, considerar que en el futuro se quiera agregar nuevos tipos de eventos.
- Comentarios en el código, especialmente en los puntos que considere necesario para facilitar la evaluación y seguir la línea de razonamiento.
- Commits triviales y representativos de cada paso realizado.
## GitHub
1. Clonar el proyecto **Coding Test Java Spring**.
2. Pushear el código a una branch con el nombre del usuario.
3. Crear un PR a la branch **develop**.
## Anexo
### Chequear días, meses o años específicos:
Es posible especificar el día, mes o año. Se aclara que si especifica un día, también debe incluir un mes y un año. Si especifica un mes, también debe especificar el año.
Por ejemplo, esto retorna todos los feriados en los EE.UU. en enero de 2023:
```
https://holidays.abstractapi.com/v1/
?api_key=YOUR_UNIQUE_API_KEY
&country=US
&year=2023
&month=01
```
Y esto retornaría cualquier feriado en los EE.UU. el 1 de enero de 2023:
```
https://holidays.abstractapi.com/v1/
?api_key=YOUR_UNIQUE_API_KEY
&country=US
&year=2023
&month=01
&day=01
```
Si la consulta es válida pero no hay feriados en el período revisado, obtendrá una respuesta 200 con un arreglo vacío.

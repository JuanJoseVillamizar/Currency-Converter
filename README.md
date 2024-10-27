
- [English](#english)
- [Español](#español)

## English
# Currency-Converter
## Description
The **Currency Converter** is a console application that allows users to convert amounts between different currencies (Dollar, Argentine Peso, Brazilian Real, and Colombian Peso). It uses an external API to fetch real-time exchange rates.

## Features

- Conversion between different currency pairs.
- Error handling and input validation.
- Simple and user-friendly interface.
- API key protected

## Technologies Used

- Java
- GSON (for JSON handling)
- Java HttpClient (to make HTTP requests)
## Prerequisites

- **Java JDK** (version 11 or higher)
- **API Key** from an exchange rate service. You can obtain one from [ExchangeRate API](https://www.exchangerate-api.com/)
- **Gson** From json or to json files . You can obtain one from [MVN Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson)

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/JuanJoseVillamizar/Currency-Converter.git

2. **Navigate to the project directory:**
    
   ```bash
   cd Currency-Converter
   
3. **Set up your environment file:**
    Create a file named .env in the root of the project and add your API key:
   ```bash 
    EXCHANGE_API_KEY=your_api_key_here
   
## Gson dependency 

You need to add the `gson.jar` file to your project dependencies. Follow these steps (If you are using IntelliJ IDEA): 

1. Go to the project structure by pressing `Ctrl + Alt + Shift + S`.
2. In the **Modules** section, select your project module.
3. Click on the **Dependencies** tab.
4. Click the `+` icon, select **JARs or directories**, and navigate to the location where you saved `gson.jar`.
5. Click **OK** to add it to your project.


## Usage

1. **Run Application**
2. **Follow the instructions in the console:**
Choose an option from the menu to convert between currencies.
Enter the amount you wish to convert.
The application will display the conversion result.
3. **You can exit the application by choosing option 7) Exit.**

## Example usage

*********************************************************
         1) Dollar --> Argentine Peso
         2) Argentine Peso --> Dollar
         3) Dollar --> Brazilian Real
         4) Brazilian Real --> Dollar
         5) Dollar --> Colombian Peso
         6) Colombian Peso --> Dollar
         7) Exit

Please enter the option (1-7):  
1  
Please enter the amount you wish to convert:  
100    
100.00 USD = 9000.00 ARS
*********************************************************

## Español

# Conversor de monedas
## Descripción
El **Conversor de monedas** es una aplicación de consola que permite a los usuarios convertir cantidades entre diferentes monedas (Dolar, Pesos Argentinos, Reales Brasileños y pesos Colombianos). La aplicación usa una API externa para traer los valores en tiempo real.
## Características

- Conversión entre diferentes pares de monedas.
- Manejo de errores y validación de entradas.
- Interfaz simple y amigable con el usuario.
- Protección de la clave de Usuario API_KEY.

## Technologies Used

- Java
- GSON (Para manejar JSONS)
- Java HttpClient (Para hacer pedidos HTTP)
## Pre requisitos

- **Java JDK** (version 11 or mayor)
- **API Key** De un servicio de tipo de cambio. Tu puedes obtener una en: [ExchangeRate API](https://www.exchangerate-api.com/)
- **Gson** Para manejar Archivos Json . Puedes obtener el JAR en : [MVN Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson)

## Instalación

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/JuanJoseVillamizar/Currency-Converter.git

2. **Navegar al directorio del proyeto:**

   ```bash
   cd Currency-Converter

3. **Crear tus varibales de entorno:**
     Debes crear un archivo llamado .env en la raiz de tu proyecto y agregar tu API key

   ```bash 
    EXCHANGE_API_KEY=your_api_key_here

## Dependencia Gson
Necesitas agregar el archivo `gson.jar` a las dependecnias de tu proyecto. Sigue los siguientes pasos para IntelliJ IDEA:

1. Ve a la estructura de tu proyecto en la parte superior izquierda de tu ventana y abriendo el menu para seleccionar estructura del proyecto, o puedes presionar `Ctrl + Alt + Shift + S`.
3. En la sección **Modulos** selecciona los modulos de tu proyecto
3. Debes hacer click en **Dependencias**
4. Dale click al icono `+` , Y selecciona **JARs o directorios**, Navega hasta la carpeta donde descargaste el archivo `gson.jar`.
5. Click en **OK** Y se agregara a tu proyecto.


## Usabilidad

1. **Corre la aplicación**
2. **Sigue las instrucciones en la consola:**
   Selecciona una opcion del menu para convertir las monedas.
   Presiona enter y la cantidad que deseas convertir
   La aplicacion mostrara el resultado de la operaciób en consola.
3. **Puedes salir de la aplicación presionando la opción 7) Exit.**

## Ejemplo de uso:

*********************************************************
         1) Dollar --> Argentine Peso
         2) Argentine Peso --> Dollar
         3) Dollar --> Brazilian Real
         4) Brazilian Real --> Dollar
         5) Dollar --> Colombian Peso
         6) Colombian Peso --> Dollar
         7) Exit

Please enter the option (1-7):  
1  
Please enter the amount you wish to convert:  
100    
100.00 USD = 9000.00 ARS
*********************************************************
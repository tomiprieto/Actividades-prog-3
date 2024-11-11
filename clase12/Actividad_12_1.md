# Clase 12 

## Actividad 1

### Algunos tipos de ciberataques a la plataforma web son:
  * DoS/DDoS donde se sobrecarga la plataforma con trafico excesivo para que se vuelva inaccesible. Ej. Mediante una botnet envía miles de solicitudes por segundo para saturar la plataforma y que se caiga.
  * Inyección SQL donde se inserta código SQL malicioso en la plataforma para acceder/manipular la base de datos
  * Fuerza Bruta donde se intentan todas las combinaciones posibles de contraseñas hasta encontrar la correcta


### Para detectar y evitar/mitigar estos ataques, el sistema de detección puede:
DoS/DDoS
  + Monitorear el tráfico web en tiempo real para detectar un aumento súbito y anormal.
  +	Evaluar solicitudes de una misma IP para identificar patrones sospechosos


Inyección SQL
  - Detectar en las solicitudes caracteres como: "", --, =, etc
  -	Poner filtros para validar la entrada y minimizar el riesgo de ataques


Fuerza Bruta
  -	Limitar el número de intentos para iniciar sesión
  -	Poner/complejizar barreras como captchas cuando se detectan varios intentos

## Árbol simplificado

![image](https://github.com/user-attachments/assets/3ba59ef7-c921-4703-8b53-d8648225377a)


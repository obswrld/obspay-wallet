import aio_pika
from app.config import settings

connection: aio_pika.RobustConnection | None = None

async def connect_rabbitmq():    
    global connection
    connection = await aio_pika.connect_robust(settings.rabbitmq_url)

async def disconnect_rabbitmq():
    global connection
    if connection:
        await connection.close()

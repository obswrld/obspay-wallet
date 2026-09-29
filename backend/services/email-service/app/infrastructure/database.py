import asyncpg
from app.config import settings

pool: asyncpg.Pool | None = None

async def connect_db():
    global pool
    pool = await asyncpg.create_pool(dsn=settings.database_url)


async def disconnect_db():
    if pool:
        await pool.close()
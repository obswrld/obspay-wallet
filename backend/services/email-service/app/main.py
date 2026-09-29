from app.config import settings
from fastapi import FastAPI
from app.infrastructure.database import connect_db, disconnect_db


app = FastAPI(title="ObsPay Email Service")

@app.on_event("startup")
async def startup():
    await connect_db()


@app.on_event("shutdown")
async def shutdown():
    await disconnect_db()


@app.get("/health")
async def health_check():
    return {
        "status": "ok",
        "service": "Email-Service",
        "environment": settings.environment,
    }

@app.get("/db-check")
async def db_check():
    from app.infrastructure import database
    async with database.pool.acquire() as conn:
        result = await conn.fetchval("SELECT 1")
    return {"database": "connected", "result": result}

from pydantic_settings import BaseSettings

class Settings(BaseSettings):
    environment: str = "development"
    service_name: str = "email-service"
    database_url: str = ""

    class Config:
        env_file = ".env"

settings = Settings()
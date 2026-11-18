CREATE EXTENSION IF NOT EXISTS vector;
CREATE EXTENSION IF NOT EXISTS hstore;
create Table if not exists vector_store (
    id Text primary key,
    content text ,
    metadata JSONB,
    embedding vector(1536)
);

-- Create Index if not exists vector_store_embedding_idx on vector_store using HSNW (embedding vector_cosine_ops) ;
CREATE INDEX IF NOT EXISTS vector_store_embedding_idx
ON vector_store USING HNSW (embedding vector_cosine_ops);
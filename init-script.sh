set -e

psql -v ON_ERROR_STOP=1 --username "postgres" --dbname "postgres" <<-EOSQL
	GRANT ALL PRIVILEGES ON DATABASE postgres TO postgres;
EOSQL

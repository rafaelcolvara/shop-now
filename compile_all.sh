PROJECT_DIRS=("order-ms" "product-ms" "user-ms")
DOCKER_IMAGES=("order-ms-shop-now:1.0" "product-ms-shop-now:1.0" "user-ms-shop-now:1.0")


# Navegue para cada diretório de projeto e execute o Maven
for dir in "${PROJECT_DIRS[@]}"; do
  echo "Compilando e empacotando o projeto: $dir"
  cd "$dir"
  image=${DOCKER_IMAGES[$index]}
  echo "Imagem Docker: $image"
  # Execute o Maven para compilar e gerar o JAR
  mvn clean install

  # Construa a imagem Docker
   docker build -t "$image" .

   docker push "$image"

  # volte para o diretório pai
   cd ..

  echo "Concluído: $dir"
  echo "--------------------------------"
done

echo "Todos os projetos foram compilados e empacotados com sucesso."

# Criando TODO List apenas utilizando Java

___

> O programa é simples e pode ser testado via terminal. Ele foi compilado e para conseguir executá-lo, é necessário que você possua pelo menos o JDK 17 ou uma versão mais recente.
___

**1°** - Clone o repositório em alguma local da sua máquina

*Execute o seguinte comando no terminal:*
```bash
    git clone <url-do-repositorio> <especifique-qual-nome-você-deseja>
```
___
**2°** - verifique se você possui o java instalado na sua máquina.

*Execute o seguinte comando no terminal para verificar se ele está instalado:*
```bash
    java -version 
```
*ou*
```bash
    java --version 
```

**Obs: *Caso esteja instalado é só seguir o passo a passo normalmente. Se não estiver instalado é `importante` instalá-lo para que o programa funcione.***
___
>   **Depois de instalar o JDK >= 17**
___
**3°** - Extraia ou abra a pasta root do projeto onde está o `toDoList.jar`.

*Execute o seguinte comando no terminal:*
```bash
    java -jar toDoList.jar
```
___

### É importante ressaltar alguns pontos:
  * Caso você opte por extrair o **_.jar_** para um pasta vazia,  ao rodar o programa ele tenta verificar se há o arquivo `TODO-TASK-LIST.txt`, para buscar dados.
  * Caso o arquivo não exista, ao finalizar o programa inserindo `0` como resposta no terminal, ele automaticamente criará esse arquivo. Não se preocupe.
  * Você pode copiar o `TODO-TASK-LIST.txt` presente no repositório para aproveitar os dados caso queira.
  * **Quando há dados a serem salvos no arquivo:**
    * Automaticamente quando o programa inicia, ele busca os dados do arquivo e ao sair **_pelo menu interativo_**, ele substitui os dados do arquivo pelo que está na memória.  
    * Dessa forma, a exclusão de uma task é persistida sempre que você sai da aplicação.
    * Nesse sentido, sempre que uma task é adicionada pra que ela persista no arquivo.txt e caso você queira que ela exista ao sair do programa e executá-lo novamente, é preciso sair pelo menu usando `0` como input.
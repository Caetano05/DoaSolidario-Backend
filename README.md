COMO REALIZAR A CRIAÇÃO DE UMA BRANCH E COMMITAR PELO TERMINAL

// Criação da Branch
git branch NomedaNovaBranche

// Definir a Branch pai
git branch -c main NomedaNovaBranche

// Validar a Branch criada
git checkout NomedaNovaBranche

// Realizar o commit
git commit -m "Meu commit"

// Realizar o push
git push -u origin NomedaNovaBranche

⚠️ATENÇÃO⚠:⚠️ Não copie o codigo acima, pois o terminal pode executar apos você colar, criando varias Branch.⚠️

🧩DICA:🧩 O nome da Branche pode ser relacionado a funcionalidade da mesma. EX: modal-item.🧩

ESTRUTURA DE COMMIT

feat: para adicionar um novo recurso;

fix: para corrigir um bug;

chore: para alterações no projeto que não afetam o código de produção;

docs: para alterações na documentação. 

Após o : colocar uma breve descrição

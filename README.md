
</div>
<div align="center">

# 🛡️ Sentinela 0800

**Plataforma de denúncias de golpes e fraudes financeiras**

*Projeto A3 — Análise e Desenvolvimento de Sistemas | USJT × Bradesco | 2026.1*

---

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Azure](https://img.shields.io/badge/Microsoft_Azure-0078D4?style=for-the-badge&logo=microsoftazure&logoColor=white)

</div>

---

## 📌 Sobre o projeto

#  Visão Geral

Este projeto é uma aplicação web desenvolvida em Java com Spring Boot e Thymeleaf para o cadastro e acompanhamento de denúncias. As páginas são geradas pelo servidor e exibidas diretamente no navegador do usuário.

##  Funcionamento

O usuário acessa uma página, interage com formulários e envia informações. O sistema processa os dados, aplica as regras necessárias e os armazena no banco de dados.

##  Estrutura

* **Controller:** gerencia as requisições e a navegação.
* **Service:** aplica as regras de negócio.
* **Repository:** realiza o acesso ao banco de dados.
* **Model:** representa os dados da aplicação.
* **Thymeleaf:** renderiza as páginas HTML.

##  Implementado

* Navegação entre páginas.
* Interface estilizada com CSS.
* Integração com MySQL.
* Criação automática das tabelas pelo Hibernate.

##  Próximos Passos

* Persistência completa das denúncias.
* Cadastro de telefones suspeitos.
* Estatísticas baseadas em dados reais.

##  Diferencial

O projeto utiliza tecnologias modernas do ecossistema Spring e uma arquitetura organizada, facilitando manutenção e futuras expansões.


---

##  Estrutura do banco de dados

| Tabela | Descrição |
|:---|:---|
| `usuario` | Dados dos usuários que registram denúncias |
| `telefone_suspeito` | Números denunciados e contagem de ocorrências |
| `denuncia` | Registro principal — vincula usuário, telefone e tipo de golpe |
| `estatistica` | Consolidação mensal por categoria de fraude |

> O script completo de criação está em [`Banco de Dados.sql`](./Banco%20de%20Dados.sql)

---

##  Integrantes

| Nome | RA |
|:---|:---:|
| Henry Gava Salvaia | 825122158 |
| Gustavo Almeida dos Santos Cunha | 825233519 |
| Pedro Henrique Carvalho Vieira | 824211592 |
| Gustavo Resende Fernandes | 82414925 |
| Guilherme Nolasco Tucunduva | 82426795 |
| Sandy Andrade | 8261105964 |
| Jhonattan da Costa Almeida | 82421914 |
| Arthur Frederico Piasse Pereira | 824219186 |

---

<div align="center">

*Universidade São Judas Tadeu — 2026.1*

</div>

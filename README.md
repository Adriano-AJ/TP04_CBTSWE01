# 🍪 Servlet Cookies

> Aplicação web Java EE que demonstra o uso de cookies HTTP para persistir a preferência de par de moedas do usuário.

---

## 👥 Dupla

| | Nome |
|---|---|
| 👤 | Adriano Júnior de Souza Almeida |
| 👤 | Arthur Lanzilotti Farjanes |

**📚 Disciplina:** CBTSWE1 — ADS 571  
**🧑‍🏫 Professor:** Wellington Tuler Moraes

---

## ⚙️ Tecnologias

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Servlet](https://img.shields.io/badge/Servlet_API-4.0.1-blue?logo=apache)
![Tomcat](https://img.shields.io/badge/Tomcat-9.x-yellow?logo=apachetomcat)
![Maven](https://img.shields.io/badge/Maven-3.x-red?logo=apachemaven)

---

## 🔄 Como funciona

```
1. Usuário acessa /exchange-rate
   ├── ✅ Cookie presente → exibe a cotação do par salvo
   └── ❌ Cookie ausente → redireciona para seleção de moedas
           └── Usuário escolhe o par → cookie salvo por 30 dias
```

---

## 🗂️ Servlets

| Servlet | URL | Método |
|---|---|---|
| 💾 Salvar preferência | `/save-exchange-rates-pair` | `POST` |
| 📈 Ver cotação | `/exchange-rate` | `GET` |
| 🗑️ Remover preferência | `/remove-currency-pair` | `GET` |

---

## 🚀 Como executar

```bash
# 1. Importe o projeto no Eclipse como Dynamic Web Project + Maven
# 2. Configure o runtime do Tomcat 9
# 3. Run As → Run on Server
```

Acesse: **`http://localhost:8080/TP04_CBTSWE1/exchange-rate`**

# ⚽ Série A App
Aplicativo Android para acompanhar o **Campeonato Brasileiro Série A** em tempo real.

---

## 📱 Demonstração

### v1
![APPSERIEA.gif](assets/APPSERIEA.gif)

### v2
![APPSERIEA_V2.gif](assets/APPSERIEA_V2.gif)

---

## ✨ Funcionalidades

### v1
- 📅 **Próximos jogos** — veja as partidas agendadas com data e horário no fuso de Brasília
- 🏆 **Tabela de classificação** — posição, vitórias, empates, derrotas e pontos de cada time
- ⏳ **Lazy loading** — animação de shimmer enquanto os dados carregam
- 🌙 **Dark mode** — suporte completo ao modo escuro do sistema

### v2
- 🎨 **Tema manual** — alterne entre modo claro e escuro nas configurações
- ⚙️ **Tela de configurações** — personalize a experiência do app
- 🧭 **Navegação** — roteamento entre telas com Jetpack Navigation
- 📌 **Bottom Bar** — navegação inferior entre Home, Meu Time e Configurações

---

## 🔮 Próximos passos
- 🏟️ **Tela Meu Time** — acompanhe de perto o desempenho do seu time favorito, com histórico de jogos e estatísticas
- 🏠 **Melhorias na tela inicial** — sinalização visual na tabela de classificação indicando times que se classificam para competições e times em zona de rebaixamento
- 🔔 **Notificações** — receba alertas de jogos do seu time favorito

---

## 🛠️ Tecnologias
- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **ViewModel + StateFlow**
- **Jetpack Navigation** — navegação entre telas
- **Coil** — carregamento de imagens SVG (escudos dos times)
- **Retrofit** — consumo da API

---

## 🚀 Como rodar
1. Clone o repositório
```bash
   git clone https://github.com/RaphaelNNS/SerieA.git
```
2. Abra no **Android Studio**
3. Adicione sua chave da API no projeto
4. Rode em um emulador ou dispositivo físico

---

## 📡 API
Os dados são fornecidos pela [football-data.org](https://www.football-data.org/).

---

## 📄 Licença
Este projeto está sob a licença MIT.

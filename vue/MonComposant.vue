<script setup lang="ts">
import { ref } from 'vue'

// Donnees reactives
const titre = ref<string>('Bienvenue')
const message = ref<string>('Ceci est mon premier composant Vue.js !')

// Methodes
function changerMessage(): void {
  message.value = 'Vous avez clique sur le bouton !'
}
</script>

<template>
  <!-- Structure HTML du composant -->
  <div class="mon-composant">
    <h1>{{ titre }}</h1>
    <p>{{ message }}</p>
    <button @click="changerMessage">Cliquez-moi</button>
  </div>
</template>

<style scoped>
/* Styles CSS du composant */
.mon-composant {
  padding: 20px;
  background-color: #f5f5f5;
  border-radius: 8px;
}

h1 {
  color: #42b883;
}

button {
  background-color: #42b883;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #369970;
}
</style>

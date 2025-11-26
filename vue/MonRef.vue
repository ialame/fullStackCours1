<script setup lang="ts">
import { ref } from 'vue'

// Types primitifs
const compteur = ref<number>(0)
const nom = ref<string>('Vue.js')
const actif = ref<boolean>(true)

// Acceder/modifier la valeur dans le script : utiliser .value
function incrementer(): void {
  compteur.value++
}

// Dans le template, .value n'est PAS necessaire
// {{ compteur }} fonctionne directement
</script>


<template>
  <div class="mon-composant">
    <h1>{{compteur}}</h1>
    <h2>{{ nom }}</h2>
    <p>{{ actif }}</p>
    <button @click="incrementer"> + </button>
  </div>

</template>

<style scoped>

</style>
<script setup lang="ts">
import { ref } from 'vue'

const compteur = ref<number>(0)

// Fonctions simples
function incrementer(): void {
  compteur.value++
}

function decrementer(): void {
  compteur.value--
}

function reinitialiser(): void {
  compteur.value = 0
}

// Fonction avec parametre
function afficherMessage(texte: string): void {
  alert(texte)
}

// Fonction avec retour
function doubler(n: number): number {
  return n * 2
}
</script>

<template>
  <div>
    <p>Compteur : {{ compteur }}</p>
    <p>Double : {{ doubler(compteur) }}</p>
    <button @click="incrementer">+</button>
    <button @click="decrementer">-</button>
    <button @click="reinitialiser">Reset</button>
    <button @click="afficherMessage('Bonjour!')">Dire bonjour</button>
  </div>
</template>



<style scoped>

</style>
<script setup lang="ts">
import { reactive } from 'vue'

// Definition d'une interface TypeScript
interface Utilisateur {
  prenom: string
  age: number
  adresse: {
    ville: string
    codePostal: string
  }
}

// Objet reactif
const utilisateur = reactive<Utilisateur>({
  prenom: 'Jean',
  age: 25,
  adresse: {
    ville: 'Paris',
    codePostal: '75001'
  }
})

// Tableau reactif
interface Tache {
  id: number
  titre: string
  fait: boolean
}

const taches = reactive<Tache[]>([
  { id: 1, titre: 'Apprendre Vue', fait: false },
  { id: 2, titre: 'Creer un projet', fait: false }
])

// Modifier directement (pas de .value necessaire)
function anniversaire(): void {
  utilisateur.age++
}

function ajouterTache(titre: string): void {
  taches.push({ id: Date.now(), titre, fait: false })
}
</script>


<template>
<button @click="anniversaire" > Augmenter age</button>
  <br>
  <button @click="ajouterTache('toto')"> Ajouter tâche</button>
</template>

<style scoped>

</style>
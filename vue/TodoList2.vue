<script setup lang="ts">
import { reactive } from 'vue'
import TodoItem from './TodoItem2.vue'

interface Tache {
  id: number
  titre: string
  fait: boolean
}

const taches = reactive<Tache[]>([
  { id: 1, titre: 'Apprendre Vue', fait: false },
  { id: 2, titre: 'Creer un projet', fait: true }
])

function toggleTache(id: number): void {
  const tache = taches.find(t => t.id === id)
  if (tache) {
    tache.fait = !tache.fait
  }
}

function supprimerTache(id: number): void {
  const index = taches.findIndex(t => t.id === id)
  if (index !== -1) {
    taches.splice(index, 1)
  }
}
</script>

<template>
  <div class="todo-list">
    <TodoItem
        v-for="tache in taches"
        :key="tache.id"
        :titre="tache.titre"
        :fait="tache.fait"
        @toggle="toggleTache(tache.id)"
        @supprimer="supprimerTache(tache.id)"
    />
  </div>
</template>


<style scoped>

</style>
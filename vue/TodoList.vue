<script setup lang="ts">
import { reactive } from 'vue'
import TodoItem from './TodoItem.vue'

interface Tache {
  id: number
  titre: string
  fait: boolean
  priorite: number
}

const taches = reactive<Tache[]>([
  { id: 1, titre: 'Faire les courses', fait: false, priorite: 2 },
  { id: 2, titre: 'Reviser le cours', fait: true, priorite: 1 },
  { id: 3, titre: 'Appeler maman', fait: false, priorite: 3 }
])
</script>

<template>
  <div class="todo-list">
    <h2>Ma liste de taches</h2>

    <!-- Valeurs statiques -->
    <TodoItem titre="Apprendre Vue.js" :fait="true" />

    <!-- Valeurs dynamiques avec v-bind (:) -->
    <TodoItem
        v-for="tache in taches"
        :key="tache.id"
        :titre="tache.titre"
        :fait="tache.fait"
        :priorite="tache.priorite"
    />
  </div>

</template>

<style scoped>

</style>
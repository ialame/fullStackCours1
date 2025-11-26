<script setup lang="ts">
import { ref, reactive, computed } from 'vue'

const prenom = ref<string>('Jean')
const nom = ref<string>('Dupont')

interface Tache {
  id: number
  titre: string
  fait: boolean
}

const taches = reactive<Tache[]>([
  { id: 1, titre: 'Tache 1', fait: true },
  { id: 2, titre: 'Tache 2', fait: false },
  { id: 3, titre: 'Tache 3', fait: false }
])

// Computed simple (lecture seule)
const nomComplet = computed<string>(() => {
  return `${prenom.value} ${nom.value}`
})

// Filtrer les taches non terminees
const tachesRestantes = computed<Tache[]>(() => {
  return taches.filter(t => !t.fait)
})

// Compter les taches restantes
const nombreTachesRestantes = computed<number>(() => {
  return tachesRestantes.value.length
})

// Message dynamique
const messageProgression = computed<string>(() => {
  if (nombreTachesRestantes.value === 0) {
    return 'Toutes les taches sont terminees !'
  }
  return `Il reste ${nombreTachesRestantes.value} tache(s) a faire.`
})

// Computed avec getter et setter
const nomCompletEditable = computed({
  get(): string {
    return `${prenom.value} ${nom.value}`
  },
  set(valeur: string): void {
    const parts = valeur.split(' ')
    prenom.value = parts[0] || ''
    nom.value = parts[1] || ''
  }
})
</script>

<template>
  <div>
    <p>Nom complet : {{ nomComplet }}</p>
    <p>{{ messageProgression }}</p>

    <ul>
      <li v-for="tache in tachesRestantes" :key="tache.id">
        {{ tache.titre }}
      </li>
    </ul>

    <!-- Computed avec setter -->
    <input v-model="nomCompletEditable" />
  </div>
</template>


<style scoped>

</style>
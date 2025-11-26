<script setup lang="ts">
// Declaration des props
interface Props {
  titre: string
  fait?: boolean
}

const props = withDefaults(defineProps<Props>(), {
  fait: false
})

// Declaration des evenements avec leurs types
const emit = defineEmits<{
  (e: 'toggle'): void
  (e: 'supprimer'): void
  (e: 'modifier', nouveauTitre: string): void
}>()

// Fonctions qui emettent les evenements
function onToggle(): void {
  emit('toggle')
}

function onSupprimer(): void {
  emit('supprimer')
}

function onModifier(titre: string): void {
  emit('modifier', titre)
}
</script>

<template>
  <div class="todo-item" :class="{ fait: fait }">
    <input
        type="checkbox"
        :checked="fait"
        @change="onToggle"
    />
    <span>{{ titre }}</span>
    <button @click="onSupprimer">X</button>
  </div>
</template>


<style scoped>

</style>
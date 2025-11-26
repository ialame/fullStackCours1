<script setup lang="ts">
// Methode 1 : Interface TypeScript (recommandee)
interface Props {
  titre: string
  fait?: boolean        // ? = optionnel
  priorite?: number
}

// defineProps avec valeurs par defaut via withDefaults
const props = withDefaults(defineProps<Props>(), {
  fait: false,
  priorite: 1
})

// Acceder aux props
console.log(props.titre)
console.log(props.fait)
</script>

<template>
  <div class="todo-item" :class="{ termine: fait }">
    <span>{{ titre }}</span>
    <span class="priorite">P{{ priorite }}</span>
  </div>
</template>


<style scoped>

</style>
<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const estoque = ref([])

onMounted(async () => {
    const response = await axios.get(
        'http://localhost:8080/api/casais/1/estoque'
    )

    estoque.value = response.data
})
</script>

<template>

<h1>Estoque</h1>

<ul>

<li
v-for="item in estoque"
:key="item.id">

{{ item.nome }}

</li>

</ul>

</template>
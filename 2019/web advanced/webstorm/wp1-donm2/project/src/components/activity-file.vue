<template>
    <table>
        <thead>
        <tr>
            <th>category</th>
            <th>name</th>
            <th>date</th>
            <th>description</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="activity in activities">
            <td>{{ activity.category }}</td>
            <td>{{ activity.name }}</td>
            <td>{{ activity.date }}</td>
            <td>{{ activity.description }}</td>
        </tr>
        </tbody>
    </table>
</template>

<script>
    export default {
        name: "activities-table",
        props: ["activities"]
    }
</script>
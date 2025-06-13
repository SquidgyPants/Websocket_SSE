<script>
import {Client} from "@/API.ts";
import {ref} from "vue";

const client = new Client()
const result =ref([])

export default {
  data() {
    return {
      messages: []
    };
  },
  mounted() {
    const eventSource = new EventSource("http://localhost:8080/events");

    eventSource.onmessage = (event) => {
      this.messages.push(event.data);
    };

    eventSource.onerror = (error) => {
      console.error("SSE error:", error);
      eventSource.close();
    };
  }
};

const backendMethodeAsync = async () => {
  try {
  result.value = await client.returnMessage();
  }
  catch(error) {
    console.log(error);
  }
}

</script>

<template>
  <div>
    <h2>Server-Sent Events</h2>
      <p v-if="result">{{ result.value }}</p>
      <button onclick="this.backendMethodeAsync" >Call SSE</button>
  </div>
</template>


<style scoped>

</style>
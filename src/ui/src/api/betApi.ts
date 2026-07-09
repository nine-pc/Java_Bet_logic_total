import api from "./axios";
import type { Bet } from "../types/Bet";

export async function placeBet(bet: Bet) {

    const response = await api.post("/bets", bet);

    return response.data;
}
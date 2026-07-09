import api from "./axios";
import type { Outcome } from "../types/Outcome";

export async function getOutcomes(marketId: number): Promise<Outcome[]> {

    const response =
        await api.get<Outcome[]>(`/markets/${marketId}/outcomes`);

    return response.data;

}
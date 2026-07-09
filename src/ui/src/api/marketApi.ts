import api from "./axios";
import type { Market } from "../types/Market";

export async function getMarkets(eventId: number): Promise<Market[]> {

    const response =
        await api.get<Market[]>(`/events/${eventId}/markets`);

    return response.data;
}
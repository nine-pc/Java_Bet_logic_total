import api from "./axios";
import type { Event } from "../types/Event";

export async function getEvents(): Promise<Event[]> {
    const response = await api.get<Event[]>("/events");
    return response.data;
}

export async function getEvent(id: number): Promise<Event> {
    const response = await api.get<Event>(`/events/${id}`);
    return response.data;
}

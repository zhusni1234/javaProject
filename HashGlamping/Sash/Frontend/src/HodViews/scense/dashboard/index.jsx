import { Box, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from "@mui/material";
import Header from "../../../components/Header";
import { useState, useEffect } from "react";

// Example data, you would replace this with data from an API or database
const bookings = [
    { startDate: "2024-10-10", endDate: "2024-10-12", packageType: "Luxury Tent", price: 200 },
    { startDate: "2024-10-12", endDate: "2024-10-15", packageType: "Eco Cabin", price: 150 },
    { startDate: "2024-10-14", endDate: "2024-10-16", packageType: "Treehouse", price: 250 }
];

// Helper function to calculate the duration in days
const calculateDuration = (startDate, endDate) => {
    const start = new Date(startDate);
    const end = new Date(endDate);
    const duration = Math.ceil((end - start) / (1000 * 60 * 60 * 24)); // Difference in days
    return duration;
};

const DashboardAdmin = () => {
    const [bookingList, setBookingList] = useState([]);

    // This would be replaced by a fetch call to your API
    useEffect(() => {
        // Fetch the booking data from your backend or API and update state
        // Example: fetchBookings().then(data => setBookingList(data));
        setBookingList(bookings); // Using static data for now
    }, []);

    return (
        <Box m="20px">
            <Box display="flex" justifyContent="space-between" alignItems="center">
                <Header title="DASHBOARD" subtitle="Booking List" />
            </Box>
            <Box mt="20px">
                <TableContainer component={Paper}>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell>Start Date</TableCell>
                                <TableCell>End Date</TableCell>
                                <TableCell>Duration (Days)</TableCell>
                                <TableCell>Package Type</TableCell>
                                <TableCell>Price (RM)</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {bookingList.map((booking, index) => (
                                <TableRow key={index}>
                                    <TableCell>{booking.startDate}</TableCell>
                                    <TableCell>{booking.endDate}</TableCell>
                                    <TableCell>{calculateDuration(booking.startDate, booking.endDate)}</TableCell>
                                    <TableCell>{booking.packageType}</TableCell>
                                    <TableCell>{booking.price}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
            </Box>
        </Box>
    );
};

export default DashboardAdmin;
